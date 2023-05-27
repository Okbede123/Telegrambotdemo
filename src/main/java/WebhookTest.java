import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;




public class WebhookTest extends TelegramLongPollingBot {

    static String getId;

    public void sendText(Long who, String what){
        SendMessage sm = SendMessage.builder()
                .chatId(who.toString()) //Who are we sending a message to
                .text(what).build();    //Message content
        try {
            execute(sm);

        } catch (TelegramApiException e) {
            throw new RuntimeException(e);      //Any error will be printed here
        }
    }

    @Override
    public String getBotUsername() {
        return "Duc_okbede_bot";
    }

    public String getBotToken(){
        return "5902090142:AAHLR0qxyKdl6YVQjQY8dyoy49Gtp6Gocdc";
    }

    @Override
    public void onUpdateReceived(Update update) {
        System.out.println(update.getMessage().getText());
        if (update.getMessage().getText().equals("/test")) {
            System.out.println("run vao day1");
            // Set variables
            String message_text = update.getMessage().getText();
            long chat_id = update.getMessage().getChatId();

            SendMessage message = new SendMessage();
            message.setChatId(update.getMessage().getChatId().toString());
            message.setText(message_text);
            System.out.println("run vao day2");
            try {
                execute(message); // Sending our message object to user
                System.out.println("run vao day3");
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }

    }

}
