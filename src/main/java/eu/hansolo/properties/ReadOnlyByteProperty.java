/*
 * Copyright (c) 2017 by Gerrit Grunwald
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package eu.hansolo.properties;

/**
 * Created by hansolo on 24.10.17.
 */
public class ReadOnlyByteProperty extends ReadOnlyProperty<Byte> {

    // ******************** Constructors **************************************
    public ReadOnlyByteProperty() {
        super(null, null, (byte) 0);
    }
    public ReadOnlyByteProperty(final byte VALUE) {
        super(null, null, VALUE);
    }
    public ReadOnlyByteProperty(final Object BEAN, final String NAME, final byte VALUE) {
        super(BEAN, NAME, VALUE);
    }


    // ******************** Methods *******************************************
    public byte get() { return value; }
}
