[![](https://jitpack.io/v/jwdeveloper/TikTok-Live-Java.svg)](https://jitpack.io/#jwdeveloper/TikTok-Live-Java)


# TikTokLive Java
A Java library based on [TikTokLive](https://github.com/isaackogan/TikTokLive) and [TikTokLiveSharp](https://github.com/sebheron/TikTokLiveSharp). Use it to receive live stream events such as comments and gifts in realtime from [TikTok LIVE](https://www.tiktok.com/live) by connecting to TikTok's internal WebCast push service. The package includes a wrapper that connects to the WebCast service using just the username (`uniqueId`). This allows you to connect to your own live chat as well as the live chat of other streamers. No credentials are required. Besides [Chat Comments](#chat), other events such as [Members Joining](#member), [Gifts](#gift), [Subscriptions](#subscribe), [Viewers](#roomuser), [Follows](#social), [Shares](#social), [Questions](#questionnew), [Likes](#like) and [Battles](#linkmicbattle) can be tracked. You can also send [automatic messages](#send-chat-messages) into the chat by providing your Session ID.

Join the support [discord](https://discord.gg/e2XwPNTBBr) and visit the `#java-support` channel for questions, contributions and ideas. Feel free to make pull requests with missing/new features, fixes, etc

Do you prefer other programming languages?
- **Node** orginal: [TikTok-Live-Connector](https://github.com/isaackogan/TikTok-Live-Connector) by [@zerodytrash](https://github.com/zerodytrash)
- **Python** rewrite: [TikTokLive](https://github.com/isaackogan/TikTokLive) by [@isaackogan](https://github.com/isaackogan)
- **Go** rewrite: [GoTikTokLive](https://github.com/Davincible/gotiktoklive) by [@Davincible](https://github.com/Davincible)
- **C#** rewrite: [TikTokLiveSharp](https://github.com/frankvHoof93/TikTokLiveSharp) by [@frankvHoof93](https://github.com/frankvHoof93)

**NOTE:** This is not an official API. It's a reverse engineering project.

#### Overview
- [Getting started](#getting-started)
- [Configuration](#configuration)
- [Methods](#methods)
- [Events](#events)
- [Contributing](#contributing)

## Getting started

1. Install the package via Maven

```xml
   <repositories>
    <repository>
        <id>jitpack.io</id>
        <url>https://jitpack.io</url>
    </repository>
</repositories>

<dependencies>
<dependency>
    <groupId>com.github.jwdeveloper.TikTok-Live-Java</groupId>
    <artifactId>Client</artifactId>
    <version>0.0.20-Release</version>
    <scope>compile</scope>
</dependency>
<dependency>
    <groupId>com.google.code.gson</groupId>
    <artifactId>gson</artifactId>
    <version>2.10.1</version>
</dependency>
</dependencies>
```

2. Create your first chat connection

```java
package io.github.jwdeveloper.tiktok;
import java.io.IOException;

public class SimpleExample {
    public static void main(String[] args) throws IOException {

        // set tiktok username
        TikTokLive.newClient(Main.TEST_TIKTOK_USER)
                .configure(clientSettings ->
                {

                })
                .onFollow((liveClient, event) ->
                {
                    System.out.println("Follow joined -> " + event.getNewFollower().getNickName());
                })
                .onConnected((client, event) ->
                {
                    System.out.println("Connected");
                })
                .onJoin((client, event)  ->
                {
                    System.out.println("User joined -> " + event.getUser().getNickName());
                })
                .onComment((client, event)  ->
                {
                   System.out.println(event.getUser().getUniqueId() + ": " + event.getText());
                })
                .onEvent((client, event) ->
                {
                    System.out.println("Viewers count: "+client.getRoomInfo().getViewersCount());
                })
                .onError((client, event)  ->
                {
                    event.getException().printStackTrace();
                })
                .buildAndRun();
        System.in.read();
    }
}

```
## Configuration

```java
package io.github.jwdeveloper.tiktok;

import java.io.IOException;
import java.time.Duration;
import java.util.logging.Level;

public class ConfigurationExample {
    public static void main(String[] args) throws IOException {

        TikTokLive.newClient(Main.TEST_TIKTOK_USER)
                .configure(clientSettings ->
                {
                    clientSettings.setHostName(Main.TEST_TIKTOK_USER); // TikTok user name
                    clientSettings.setClientLanguage("en"); // Language
                    clientSettings.setTimeout(Duration.ofSeconds(2)); // Connection timeout
                    clientSettings.setLogLevel(Level.ALL); // Log level
                    clientSettings.setDownloadGiftInfo(true); // Downloading meta information about gifts. You can access it by client.getGiftManager().getGiftsInfo();
                    clientSettings.setPrintMessageData(true); // Printing TikTok Protocol buffer messages in Base64 format
                    clientSettings.setPrintToConsole(true); // Printing all logs to console even if log level is Level.OFF
                    clientSettings.setHandleExistingMessagesOnConnect(true); // Invokes all TikTok events that had occurred before connection
                    clientSettings.setRetryOnConnectionFailure(true); // Reconnecting if TikTok user is offline
                    clientSettings.setRetryConnectionTimeout(Duration.ofSeconds(1)); // Timeout before next reconnection
                })
                .buildAndRun();
        System.in.read();
    }
}

```
## Listener Example

```java
package io.github.jwdeveloper.tiktok;

import io.github.jwdeveloper.tiktok.annotations.TikTokEventHandler;
import io.github.jwdeveloper.tiktok.events.TikTokEvent;
import io.github.jwdeveloper.tiktok.events.messages.TikTokCommentEvent;
import io.github.jwdeveloper.tiktok.events.messages.TikTokErrorEvent;
import io.github.jwdeveloper.tiktok.events.messages.TikTokGiftMessageEvent;
import io.github.jwdeveloper.tiktok.listener.TikTokEventListener;
import io.github.jwdeveloper.tiktok.live.LiveClient;

import java.io.IOException;

public class ListenerExample
{
    public static void main(String[] args) throws IOException {

        CustomListener customListener = new CustomListener();

        // set tiktok username
        TikTokLive.newClient(Main.TEST_TIKTOK_USER)
                .addListener(customListener)
                .buildAndRun();

        System.in.read();
    }

    /*
       Method in TikTokEventListener should meet 4 requirements to be detected
        - must have @TikTokEventHandler annotation
        - must have 2 parameters
        - first parameter must be LiveClient
        - second must be class that extending TikTokEvent
     */
    public static class CustomListener implements TikTokEventListener
    {


        @TikTokEventHandler
        public void onError(LiveClient liveClient, TikTokErrorEvent event)
        {
            System.out.println(event.getException().getMessage());
        }

        @TikTokEventHandler
        public void onCommentMessage(LiveClient liveClient, TikTokCommentEvent event)
        {
            System.out.println(event.getText());
        }

        @TikTokEventHandler
        public void onGiftMessage(LiveClient liveClient, TikTokGiftMessageEvent event)
        {
            System.out.println(event.getGift().getDescription());
        }

        @TikTokEventHandler
        public void onAnyEvent(LiveClient liveClient, TikTokEvent event)
        {
            System.out.println(event.getClass().getSimpleName());
        }

    }
}

```

## Methods
A `client (LiveClient)` object contains the following methods.

{{methods}}

| Method Name         | Description |
|---------------------| ----------- |
| connect             | Connects to the live stream. |
| disconnect          | Disconnects the connection. |
| getGiftManager      |  Gets the meta informations about all gifts. |
| getRoomInfo         | Gets the current room info from TikTok API including streamer info, room status and statistics. |
| getListenersManager | Gets and manage TikTokEventListeners    |