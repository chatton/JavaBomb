import com.chatton.javabomb.api.client.GiantBombClient;
import com.chatton.javabomb.api.client.models.GiantBombCharactersResponse;

public class Main {
    public static void main(final String[] args) {
        final String apiKey = args[0];
        final GiantBombClient gb = new GiantBombClient(apiKey);
        final GiantBombCharactersResponse resp = gb.characters()
                .limit(100)
                .offset(10)
                .get();
    }
}
