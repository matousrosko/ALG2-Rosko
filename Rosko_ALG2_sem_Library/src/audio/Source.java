package audio;

import org.lwjgl.openal.AL10;

/**
 *
 * @author rosko
 */
public class Source {
	private int sourceID;

	/**
	 * Default source
	 */
	public Source() {
		sourceID = AL10.alGenSources();
	}

	/**
	 * needed for resuming and playing the audio
	 */
	public void continuePlaying() {
		AL10.alSourcePlay(sourceID);
	}

	/**
	 * repeats the audio from the start
	 */
	public void stop() {
		AL10.alSourceStop(sourceID);
	}

	/**
	 * Enable audio loop
	 * @param loop true/flase
	 */
	public void setLooping(boolean loop) {
		AL10.alSourcei(sourceID, AL10.AL_LOOPING,
			loop ? AL10.AL_TRUE : AL10.AL_FALSE);
	}

	/**
	 * Play a buffer.
	 *
	 * @param buffer buffer.
	 */
	public void play(int buffer) {
		stop();
		AL10.alSourcei(sourceID, AL10.AL_BUFFER, buffer);
		continuePlaying();
	}

	/**
	 * Set volume
	 *
	 * @param volume 0-1
	 */
	public void setVolume(float volume) {
		AL10.alSourcef(sourceID, AL10.AL_GAIN, volume);
	}

	/**
	 * Buffer cleaning.
	 */
	public void delete() {
		stop();
		AL10.alDeleteSources(sourceID);
	}

}
