public interface GameConfigBuilder {
    GameConfigBuilder setAudioQuality(String audioQuality);
    GameConfigBuilder setControlPreference(String controlPreference);
    GameConfigManager build();
}
