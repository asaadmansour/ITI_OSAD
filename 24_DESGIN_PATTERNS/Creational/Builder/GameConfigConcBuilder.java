public class GameConfigConcBuilder implements GameConfigBuilder{
    private final String graphicsOptions;
    private String audioOptions;
    private String controlPreferences;
    public GameConfigConcBuilder(String graphicsOptions) {
        this.graphicsOptions = graphicsOptions;
    }

    @Override
    public GameConfigBuilder setAudioQuality(String audioOptions) {
        this.audioOptions = audioOptions;
        return this;
    }

    @Override
    public GameConfigBuilder setControlPreference(String controlPreferences) {
        this.controlPreferences = controlPreferences;
        return this;
    }
    public GameConfigManager build() {
        return new GameConfigManager(graphicsOptions,audioOptions,controlPreferences);
    }
}
