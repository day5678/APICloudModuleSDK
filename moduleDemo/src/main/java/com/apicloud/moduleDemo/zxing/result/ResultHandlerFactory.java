/*
 * Copyright (C) 2008 ZXing authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.apicloud.moduleDemo.zxing.result;

import com.apicloud.moduleDemo.zxing.Result;
import com.apicloud.moduleDemo.zxing.client.result.ParsedResult;
import com.apicloud.moduleDemo.zxing.client.result.ResultParser;

/**
 * Manufactures Android-specific handlers based on the barcode content's type.
 *
 * @author dswitkin@google.com (Daniel Switkin)
 */
public final class ResultHandlerFactory {
  private ResultHandlerFactory() {
  }

  public static int makeResultHandler( Result rawResult) {
    ParsedResult result = parseResult(rawResult);
    switch (result.getType()) {
      case ADDRESSBOOK:
        return 1;
      case EMAIL_ADDRESS:
        return 2;
      case PRODUCT:
        return 3;
      case URI:
        return 4;
      case WIFI:
        return 5;
      case GEO:
        return 6;
      case TEL:
        return 7;
      case SMS:
        return 8;
      case CALENDAR:
        return 9;
      case ISBN:
        return 10;
      default:
        return 11;
    }
  }

  private static ParsedResult parseResult(Result rawResult) {
    return ResultParser.parseResult(rawResult);
  }
}
