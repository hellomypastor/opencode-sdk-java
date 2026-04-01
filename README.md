# Opencode Java SDK

The official Java library for the [Opencode](https://opencode.ai) REST API.

## Requirements

- Java 11+
- Maven 3.6+

## Installation

Add the dependency to your `pom.xml`:

```xml
<dependency>
    <groupId>com.opencode</groupId>
    <artifactId>opencode-sdk-java</artifactId>
    <version>0.1.0</version>
</dependency>
```

## Usage

```java
import com.opencode.sdk.Opencode;
import com.opencode.sdk.models.session.*;

import java.util.List;

// Create client (defaults to http://localhost:54321 or OPENCODE_BASE_URL env var)
Opencode client = new Opencode();

// Create a session
Session session = client.session().create();

// Send a chat message
SessionChatParams params = SessionChatParams.builder()
    .providerID("openai")
    .modelID("gpt-5.3-chat-latest")
    .parts(List.of(new TextPartInput("Hello, how are you?")))
    .build();
client.session().chat(session.getId(), params);

// Read assistant messages
List<SessionMessagesResponse> messages = client.session().messages(session.getId());
for (SessionMessagesResponse message : messages) {
    if (!(message.getInfo() instanceof AssistantMessage)) {
        continue;
    }
    for (MessagePart part : message.getParts()) {
        if (part instanceof TextPart) {
            System.out.println(((TextPart) part).getText());
        }
    }
}
```

### Typed Message Responses

`client.session().messages(id)` returns `List<SessionMessagesResponse>`.

- `SessionMessagesResponse.info` is a typed `Message`
- `SessionMessagesResponse.parts` is a typed `List<MessagePart>`

You can safely branch on the concrete subclasses:

```java
SessionMessagesResponse response = client.session().messages(session.getId()).get(0);

if (response.getInfo() instanceof AssistantMessage) {
    AssistantMessage info = (AssistantMessage) response.getInfo();
    System.out.println(info.getModelID());
}

for (MessagePart part : response.getParts()) {
    if (part instanceof TextPart) {
        System.out.println(((TextPart) part).getText());
    } else if (part instanceof StepFinishPart) {
        System.out.println(((StepFinishPart) part).getType());
    }
}
```

### Custom Configuration

```java
import com.opencode.sdk.Opencode;
import com.opencode.sdk.core.ClientOptions;

Opencode client = new Opencode(ClientOptions.builder()
    .baseUrl("http://localhost:12345")
    .timeout(30_000)
    .maxRetries(3)
    .build());
```

### Streaming Events (SSE)

```java
import com.opencode.sdk.core.SseEventListener;
import com.opencode.sdk.models.event.EventListResponse;
import okhttp3.sse.EventSource;

EventSource source = client.event().list(new SseEventListener<EventListResponse>() {
    @Override
    public void onEvent(EventListResponse event) {
        System.out.println("Event: " + event.getType());
    }

    @Override
    public void onError(Throwable t) {
        t.printStackTrace();
    }
});

// Cancel the stream when done
source.cancel();
```

### Error Handling

```java
import com.opencode.sdk.errors.*;

try {
    client.session().delete("nonexistent-id");
} catch (NotFoundError e) {
    System.out.println("Not found: " + e.getMessage());
} catch (RateLimitError e) {
    System.out.println("Rate limited: " + e.getMessage());
} catch (ApiError e) {
    System.out.println("API error " + e.getStatusCode() + ": " + e.getMessage());
}
```

## API Reference

### App

| Method | Description |
|--------|-------------|
| `client.app().get()` | Get app info |
| `client.app().init()` | Initialize the app |
| `client.app().log(params)` | Write a log entry |
| `client.app().modes()` | List all modes |
| `client.app().providers()` | List all providers |

### Session

| Method | Description |
|--------|-------------|
| `client.session().create()` | Create a new session |
| `client.session().list()` | List all sessions |
| `client.session().delete(id)` | Delete a session |
| `client.session().abort(id)` | Abort a session |
| `client.session().chat(id, params)` | Send a message |
| `client.session().init(id, params)` | Generate AGENTS.md |
| `client.session().messages(id)` | Get message history |
| `client.session().revert(id, params)` | Revert a message |
| `client.session().share(id)` | Share a session |
| `client.session().summarize(id, params)` | Summarize a session |
| `client.session().unrevert(id)` | Unrevert a message |
| `client.session().unshare(id)` | Unshare a session |

### Config

| Method | Description |
|--------|-------------|
| `client.config().get()` | Get config info |

### Event

| Method | Description |
|--------|-------------|
| `client.event().list(listener)` | Stream SSE events |

### File

| Method | Description |
|--------|-------------|
| `client.file().read(path)` | Read a file |
| `client.file().status()` | Get file status |

### Find

| Method | Description |
|--------|-------------|
| `client.find().files(query)` | Find files |
| `client.find().symbols(query)` | Find symbols |
| `client.find().text(pattern)` | Find text |

### TUI

| Method | Description |
|--------|-------------|
| `client.tui().appendPrompt(params)` | Append to prompt |
| `client.tui().openHelp()` | Open help |

## License

MIT
