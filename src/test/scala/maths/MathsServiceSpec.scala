/*
 * Copyright 2017 HM Revenue & Customs
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

package maths

import org.scalatest.{BeforeAndAfterEach, WordSpec}
import org.scalatest.mockito.MockitoSugar
import org.mockito.ArgumentMatchers
import org.mockito.Mockito._

class MathsServiceSpec extends WordSpec with MockitoSugar with BeforeAndAfterEach {

  val mockMathsConnector = mock[MathsConnector]

  class Setup {
    val testService = new MathsService {
      override val mathsConnector = mockMathsConnector
    }
  }

  override def beforeEach() = {
    reset(mockMathsConnector)
  }

  "nextStringIsLowerCase" should {
    "return true for lower case" in new Setup {
      assert(testService.nextStringIsLowerCase() == true)
    }

    "return false for not all lower case" in new Setup {
      assert(testService.nextStringIsLowerCase() == false)
    }
  }

}
