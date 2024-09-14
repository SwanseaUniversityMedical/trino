/*
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
package io.trino.spi.protocol;

import io.trino.spi.QueryId;

import static java.util.Objects.requireNonNull;

public record SpoolingContext(String encoding, QueryId queryId, long rowCount, long size)
{
    public SpoolingContext
    {
        requireNonNull(queryId, "queryId is null");
        requireNonNull(encoding, "encoding is null");
        if (rowCount < 0) {
            throw new IllegalArgumentException("rowCount is negative");
        }
        if (size < 0) {
            throw new IllegalArgumentException("size is negative");
        }
    }
}