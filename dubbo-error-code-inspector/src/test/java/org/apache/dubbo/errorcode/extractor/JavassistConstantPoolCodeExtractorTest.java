/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.dubbo.errorcode.extractor;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Unit tests of JavassistConstantPoolCodeExtractor.
 */
class JavassistConstantPoolCodeExtractorTest {

    private static final JavassistConstantPoolErrorCodeExtractor ERROR_CODE_EXTRACTOR = new JavassistConstantPoolErrorCodeExtractor();

    @Test
    void testGettingErrorCodes() {
        String resourceFilePath = getClass().getClassLoader().getResource("FileCacheStore.class").toString();

        if (resourceFilePath.startsWith("file:/")) {
            resourceFilePath = resourceFilePath.replace("file:/", "");
        }

        Assertions.assertTrue(ERROR_CODE_EXTRACTOR.getErrorCodes(resourceFilePath).contains("0-4"));
    }
}