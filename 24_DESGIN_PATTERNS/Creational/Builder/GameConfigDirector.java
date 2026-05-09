public class GameConfigDirector {
    private final GameConfigEffectiveBuilder.Builder builder;

    public GameConfigDirector(GameConfigEffectiveBuilder.Builder builder) {
        this.builder = builder;
    }

    public GameConfigEffectiveBuilder buildLowEndConfig() {
        return builder.setAudioQuality("Low")
                      .setControlPreference("Keyboard")
                      .build();
    }

    public GameConfigEffectiveBuilder buildHighEndConfig() {
        return builder.setAudioQuality("Ultra")
                      .setControlPreference("Controller")
                      .build();
    }
}
