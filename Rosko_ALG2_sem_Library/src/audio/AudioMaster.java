package audio;

import java.nio.IntBuffer;
import java.nio.ShortBuffer;
import java.util.ArrayList;
import java.util.List;
import org.lwjgl.openal.AL;
import org.lwjgl.openal.AL10;
import org.lwjgl.openal.AL11;
import org.lwjgl.openal.ALC;
import static org.lwjgl.openal.ALC10.ALC_DEFAULT_DEVICE_SPECIFIER;
import static org.lwjgl.openal.ALC10.alcCloseDevice;
import static org.lwjgl.openal.ALC10.alcCreateContext;
import static org.lwjgl.openal.ALC10.alcDestroyContext;
import static org.lwjgl.openal.ALC10.alcGetString;
import static org.lwjgl.openal.ALC10.alcMakeContextCurrent;
import static org.lwjgl.openal.ALC10.alcOpenDevice;
import org.lwjgl.openal.ALCCapabilities;
import org.lwjgl.openal.ALCapabilities;
import org.lwjgl.stb.STBVorbis;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.libc.LibCStdlib;

/**
 * 
 *
 * @author rosko
 */
public class AudioMaster {

	/**
	 * Context of OpenAL
	 */
	private static long context;

	/**
	 * Audio Device
	 */
	private static long device;

	/**
	 * OpenAL Buffers
	 */
	private static List<Integer> buffers = new ArrayList<>();

	/**
	 * AudioMaster initialization

	 */
	public static void init() {
		String defaultDeviceName = alcGetString(0, ALC_DEFAULT_DEVICE_SPECIFIER);
		device = alcOpenDevice(defaultDeviceName);

		int[] attributes = {0};
		context = alcCreateContext(device, attributes);
		alcMakeContextCurrent(context);

		ALCCapabilities alcCapabilities = ALC.createCapabilities(device);
		ALCapabilities alCapabilities = AL.createCapabilities(alcCapabilities);

		if (alCapabilities.OpenAL10) {
			//OpenAL 1.0 is supported
		}
		
		AL10.alListenerf(AL11.AL_GAIN, 1.0f);

		AL10.alDistanceModel(AL11.AL_EXPONENT_DISTANCE);
	}

	/**
	 * Loads a sound file and places it into an OpenAL buffer
	 *
	 * @param file sound file, .ogg only
	 * @return ID of the OpenAL buffer
	 */
	public static int loadSound(String file) {
		int buffer = AL10.alGenBuffers();
		buffers.add(buffer);

		//Push the memory stack
		MemoryStack.stackPush();
		IntBuffer channelsBuffer = MemoryStack.stackMallocInt(1);
		MemoryStack.stackPush();
		IntBuffer sampleRateBuffer = MemoryStack.stackMallocInt(1);

		//Loads the audio file into the buffer
		ShortBuffer rawAudioBuffer = STBVorbis.stb_vorbis_decode_filename(file,
			channelsBuffer, sampleRateBuffer);

		int channels = channelsBuffer.get();
		int sampleRate = sampleRateBuffer.get();
		MemoryStack.stackPop();
		MemoryStack.stackPop();

		int format = -1;
		if (channels == 1) {
			format = AL10.AL_FORMAT_MONO16;
		} else if (channels == 2) {
			format = AL10.AL_FORMAT_STEREO16;
		}

		AL10.alBufferData(buffer, format, rawAudioBuffer, sampleRate);

		LibCStdlib.free(rawAudioBuffer);

		return buffer;
	}

	/**
	 * cleans up all buffers
	 */
	public static void cleanUp() {
		for (int buffer : buffers) {
			AL10.alDeleteBuffers(buffer);
		}
		alcDestroyContext(context);
		alcCloseDevice(device);
	}

}
