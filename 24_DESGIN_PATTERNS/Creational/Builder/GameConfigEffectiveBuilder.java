public class GameConfigEffectiveBuilder {
    private final String graphicsOptions;
    private final String audioOptions;
    private final String controlPreferences;
    private GameConfigEffectiveBuilder(Builder builder) {
        this.graphicsOptions = builder.graphicsOptions;
        this.audioOptions = builder.audioOptions;
        this.controlPreferences = builder.controlPreferences;
    }

    public String getGraphicsOptions() { return graphicsOptions; }
    public String getAudioOptions() { return audioOptions; }
    public String getControlPreferences() { return controlPreferences; }

    public static class Builder {
        private final String graphicsOptions;
        private String audioOptions;
        private String controlPreferences;

        public Builder(String graphicsOptions) {
            this.graphicsOptions = graphicsOptions;
        }

        public Builder setAudioQuality(String audioOptions) {
            this.audioOptions = audioOptions;
            return this;
        }

        public Builder setControlPreference(String controlPreferences) {
            this.controlPreferences = controlPreferences;
            return this;
        }

        public GameConfigEffectiveBuilder build() {
            return new GameConfigEffectiveBuilder(this);
        }
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
