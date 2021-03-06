/**
 * Copyright (c) 2014 Netheos (http://www.netheos.net)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package net.netheos.pcsapi.request;

import java.io.IOException;

import net.netheos.pcsapi.exceptions.CRetriableException;
import net.netheos.pcsapi.exceptions.CStorageException;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpUriRequest;

/**
 * Simple implementation of {@link HttpExecutor} which execute directly the given request.
 */
public class SimpleHttpExecutor
        implements HttpExecutor
{

    private final HttpClient client;

    public SimpleHttpExecutor( HttpClient client )
    {
        this.client = client;
    }

    @Override
    public CResponse execute( HttpUriRequest request )
            throws CStorageException
    {
        try {
            HttpResponse response = client.execute( request );
            return new CResponse( request, response );

        } catch ( IOException ex ) {
            throw new CRetriableException( ex );
        }
    }

}
