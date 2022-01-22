package ru.sliva.ezchat.locale;

import net.kyori.adventure.text.Component;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.configurate.ConfigurationNode;
import ru.sliva.ezchat.EzChat;
import ru.sliva.ezchat.text.TextUtil;

public enum HoverEvents {

    tellMessage("tell-message"),
    copyMessage("copy-message");

    private final ConfigurationNode node;

    HoverEvents(@NotNull String key) {
        this.node = EzChat.getInstance().getLocaleConfig().getHoverEvents().node(key);
    }

    public @NotNull String getString() {
        return TextUtil.fromNullable(node.getString());
    }

    public @NotNull Component getComponent() {
        return TextUtil.ampersandSerializer.deserialize(getString());
    }
}
