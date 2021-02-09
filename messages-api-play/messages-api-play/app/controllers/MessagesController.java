package controllers;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.inject.Inject;
import infrastructure.exceptions.AppException;
import models.Message;
import play.http.HttpEntity;
import play.libs.Json;
import play.mvc.*;
import services.MessageService;

import java.util.Optional;
import java.util.UUID;

/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class MessagesController extends Controller {

    private final MessageService messageService;

    @Inject
    public MessagesController(MessageService messageService) {
        this.messageService = messageService;
    }

    public Result getMessage(UUID id) throws Exception {
        Message message = messageService.get(id);
        return ok(Json.toJson(message));
    }

    public Result saveMessage(Http.Request request) throws Exception {
        Optional<Message> message = request.body().parseJson(Message.class);
        if (message.isEmpty()) {
            return Results.badRequest();
        }
        UUID messageId = this.messageService.save(message.get());
        return ok(messageId.toString());
    }
}
