/**
 *  Copyright 2012-2014 Gunnar Morling (http://www.gunnarmorling.de/)
 *  and/or other contributors as indicated by the @authors tag. See the
 *  copyright.txt file in the distribution for a full listing of all
 *  contributors.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package org.mapstruct.ap.test.exceptions;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.mapstruct.ap.testutil.IssueKey;
import org.mapstruct.ap.testutil.WithClasses;
import org.mapstruct.ap.testutil.runner.AnnotationProcessorTestRunner;

/**
 *
 * @author Sjaak Derksen
 */
@WithClasses( {
    Source.class,
    Target.class,
    SourceTargetMapper.class,
    ExceptionTestMapper.class,
    TestException1.class,
    TestException2.class } )
@RunWith( AnnotationProcessorTestRunner.class )
public class ExceptionTest {

    @Test(expected = RuntimeException.class)
    @IssueKey( "198" )
    public void shouldThrowRuntime() throws TestException2 {
        Source source = new Source();
        source.setSize( 1 );
        SourceTargetMapper sourceTargetMapper = SourceTargetMapper.INSTANCE;
        sourceTargetMapper.sourceToTarget( source );
    }

    @Test(expected = TestException2.class)
    @IssueKey( "198" )
    public void shouldThrowTestException2() throws TestException2 {
        Source source = new Source();
        source.setSize( 2 );
        SourceTargetMapper sourceTargetMapper = SourceTargetMapper.INSTANCE;
        sourceTargetMapper.sourceToTarget( source );
    }

}
