/*
 *   Copyright 2014-2021 Hunan Huinong Technology Co.,Ltd.
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *        https://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 *
 */

package com.cnhnkj.pigsy.core;

import static org.assertj.core.api.Assertions.assertThat;

import com.cnhnkj.pigsy.core.errors.PigsyGatewayException;
import com.cnhnkj.pigsy.core.utils.VersionUtil;
import org.junit.Test;

/**
 * @author longzhe[longzhe@cnhnkj.com]
 */
public class VersionUtilTest {

  @Test
  public void testVersionUtil() {
    assertThat(VersionUtil.compareVersion("1.0.0", "1.0.0")).isEqualTo(0);
    assertThat(VersionUtil.compareVersion("1.0.1", "1.0.0")).isGreaterThan(0);
    assertThat(VersionUtil.compareVersion("1.0.2", "1.0.0")).isGreaterThan(0);
    assertThat(VersionUtil.compareVersion("1.1.0", "1.0.0")).isGreaterThan(0);
    assertThat(VersionUtil.compareVersion("1.0.0", "1.0.1")).isLessThan(0);
    assertThat(VersionUtil.compareVersion("1.0.0", "1.0.2")).isLessThan(0);
    assertThat(VersionUtil.compareVersion("1.0.0", "1.1.0")).isLessThan(0);
  }

  @Test(expected= PigsyGatewayException.class)
  public void testErrorVersion() {
    VersionUtil.compareVersion("1.0", "1.0.0");
  }

  @Test(expected= PigsyGatewayException.class)
  public void testVersionLengthError() {
    VersionUtil.compareVersion("1.0.0", "1.0");
  }
}