/**
 * The MIT License (MIT)
 * 
 * Copyright (c) 2014 Minestar.de
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package de.minestar.conair.network;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Optional;

import org.junit.Test;

import de.minestar.conair.api.WrappedPacket;

/*
 * Test for serialization and parsing of packets
 */
public class PacketTest {

    @Test
    public void test() {
        // Create test packet
        ChatPacket sentPacket = new ChatPacket("Das Pferd frisst keinen Gurkensalat!");
        // Serialize packet while wrapping
        WrappedPacket wrappedPacket = WrappedPacket.create(sentPacket);
        // Parse packet
        Optional<ChatPacket> possibleResult = wrappedPacket.getPacket();
        assertTrue(possibleResult.isPresent());
        ChatPacket receivedPacket = possibleResult.get();
        // Check if messages are equal
        assertEquals(sentPacket.getMessage(), receivedPacket.getMessage());
    }

}
