/**
 * Copyright (c) 2017 The Semux Developers
 *
 * Distributed under the MIT software license, see the accompanying file
 * LICENSE or https://opensource.org/licenses/mit-license.php
 */
package org.semux.net.msg.consensus;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Collections;

import org.junit.Test;
import org.semux.consensus.Proof;

public class BFTNewViewMessageTest {
    @Test
    public void testSerialization() {
        int height = 1;
        int view = 1;
        Proof proof = new Proof(height, view, Collections.emptyList());

        BFTNewViewMessage msg = new BFTNewViewMessage(proof);
        BFTNewViewMessage msg2 = new BFTNewViewMessage(msg.getEncoded());
        assertEquals(height, msg2.getHeight());
        assertEquals(view, msg2.getView());
        assertTrue(msg2.getProof().getVotes().isEmpty());
    }
}
