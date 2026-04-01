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
    <version>0.1.0-alpha.1</version>
</dependency>
```

## Usage

```java
import com.opencode.sdk.Opencode;
import com.opencode.sdk.models.app.App;
import com.opencode.sdk.models.session.*;

import java.util.List;

// Create client (defaults to http://localhost:54321 or OPENCODE_BASE_URL env var)
Opencode client = new Opencode();

// Get app info
App app = client.app().get();
System.out.println("CWD: " + app.getPath().getCwd());

// Create a session
Session session = client.session().create();

// Send a chat message
SessionChatParams params = SessionChatParams.builder()
    .modelID("anthropic/claude-sonnet-4-20250514")
    .providerID("anthropic")
    .parts(List.of(new TextPartInput("Hello, how are you?")))
    .build();
client.session().chat(session.getId(), params);

// List all sessions
List<Session> sessions = client.session().list();
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
