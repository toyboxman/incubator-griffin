/*
Licensed to the Apache Software Foundation (ASF) under one
or more contributor license agreements.  See the NOTICE file
distributed with this work for additional information
regarding copyright ownership.  The ASF licenses this file
to you under the Apache License, Version 2.0 (the
"License"); you may not use this file except in compliance
with the License.  You may obtain a copy of the License at

  http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing,
software distributed under the License is distributed on an
"AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
KIND, either express or implied.  See the License for the
specific language governing permissions and limitations
under the License.
*/
package org.apache.griffin.measure.step

import org.apache.griffin.measure.Loggable
import org.apache.griffin.measure.context.DQContext

/**
  * Defines an interface about data quality step of processing
  *
  * @see org.apache.griffin.measure.step.read.ReadStep
  * org.apache.griffin.measure.step.write.WriteStep
  * org.apache.griffin.measure.step.transform.TransformStep
  * org.apache.griffin.measure.step.SeqDQStep
  */
trait DQStep extends Loggable {

  val name: String

  /**
    * Execute calculation based on context
    *
    * @param context all data for calculation
    * @return true if this step execution is successful
    * @see DQContext
    */
  def execute(context: DQContext): Boolean

  def getNames(): Seq[String] = name :: Nil

}

/**
  * Defines a finite set of values specific to the DQStepStatus
  * [PENDING, RUNNING, COMPLETED, FAILED]
  */
object DQStepStatus extends Enumeration {
  val PENDING = Value
  val RUNNING = Value
  val COMPLETED = Value
  val FAILED = Value
}


