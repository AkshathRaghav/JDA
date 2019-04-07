/*
 * Copyright 2015-2019 Austin Keener, Michael Ritter, Florian Spieß, and the JDA contributors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package net.dv8tion.jda.api.entities;

/**
 * Enum used to differentiate between the different types of Discord channels.
 */
public enum ChannelType
{
    /**
     * A {@link net.dv8tion.jda.api.entities.TextChannel TextChannel}, Guild-Only.
     */
    TEXT(0, true),
    /**
     * A {@link net.dv8tion.jda.api.entities.PrivateChannel PrivateChannel}.
     */
    PRIVATE(1),
    /**
     * A {@link net.dv8tion.jda.api.entities.VoiceChannel VoiceChannel}, Guild-Only.
     */
    VOICE(2, true),
    /**
     * A Group. {@link net.dv8tion.jda.api.AccountType#CLIENT AccountType.CLIENT} only.
     */
    GROUP(3),
    /**
     * A {@link net.dv8tion.jda.api.entities.Category Category}, Guild-Only.
     */
    CATEGORY(4, true),
    /**
     * Unknown Discord channel type. Should never happen and would only possibly happen if Discord implemented a new
     * channel type and JDA had yet to implement support for it.
     */
    UNKNOWN(-1);

    protected final int id;
    protected final boolean isGuild;

    ChannelType(int id)
    {
        this(id, false);
    }

    ChannelType(int id, boolean isGuild)
    {
        this.id = id;
        this.isGuild = isGuild;
    }

    /**
     * The Discord id key used to represent the channel type.
     *
     * @return The id key used by discord for this channel type.
     */
    public int getId()
    {
        return id;
    }

    /**
     * Whether this ChannelType is present for a {@link GuildChannel GuildChannel}
     *
     * @return Whether or not this a GuildChannel
     */
    public boolean isGuild()
    {
        return isGuild;
    }

    /**
     * Static accessor for retrieving a channel type based on its Discord id key.
     *
     * @param  id
     *         The id key of the requested channel type.
     *
     * @return The ChannelType that is referred to by the provided key. If the id key is unknown, {@link #UNKNOWN} is returned.
     */
    public static ChannelType fromId(int id)
    {
        if (id == 5) // NEWS = TEXT
            return TEXT;
        for (ChannelType type : values())
        {
            if (type.id == id)
                return type;
        }
        return UNKNOWN;
    }
}