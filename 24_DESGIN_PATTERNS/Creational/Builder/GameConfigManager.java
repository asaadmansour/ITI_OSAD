public class GameConfigManager {
    private final String graphicsOptions;
    private final String audioOptions;
    private final String controlPreferences;

    GameConfigManager(String graphicsOptions, String audioOptions, String controlPreferences) {
        this.graphicsOptions = graphicsOptions;
        this.audioOptions = audioOptions;
        this.controlPreferences = controlPreferences;
    }

    public String getGraphicsOptions() {
        return graphicsOptions;
    }

    public String getAudioOptions() {
        return audioOptions;
    }

    public String getControlPreferences() {
        return controlPreferences;
    }
    @Override
    public String toString() {
        return "GameConfig{" +
                "graphicsOptions='" + graphicsOptions + '\'' +
                ", audioOptions='" + audioOptions + '\'' +
                ", controlPreferences='" + controlPreferences + '\'' +
                '}';
    }
}
