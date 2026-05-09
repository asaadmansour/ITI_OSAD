public class Main {
    public static void main(String[] args) {
        GameConfigManager gameConfigManager = new GameConfigConcBuilder("High")
                .setAudioQuality("Medium").setControlPreference("Keyboard").build();
        System.out.println(gameConfigManager);
    }
}
