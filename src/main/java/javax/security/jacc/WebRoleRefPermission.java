/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

//
// This source code implements specifications defined by the Java
// Community Process. In order to remain compliant with the specification
// DO NOT add / change / or delete method signatures!
//

package javax.security.jacc;

import java.io.Serializable;
import java.security.Permission;

/**
 * @version $Rev: 931610 $ $Date: 2010-04-07 18:21:39 +0200 (Wed, 07 Apr 2010) $
 */
public final class WebRoleRefPermission extends Permission implements Serializable {

    private static final long serialVersionUID = 1L;

    private transient int cachedHashCode = 0;
    private String actions;

    public WebRoleRefPermission(String name, String role) {
        super(name);

        actions = role;
    }

    public boolean equals(Object o) {
        if (o == null || !(o instanceof WebRoleRefPermission)) return false;

        WebRoleRefPermission other = (WebRoleRefPermission)o;
        return getName().equals(other.getName()) && actions.equals(other.actions);
    }

    public String getActions() {
        return actions;
    }

    public int hashCode() {
        if (cachedHashCode == 0) {
            cachedHashCode = getName().hashCode() ^ actions.hashCode();
        }
        return cachedHashCode;
    }

    public boolean implies(Permission permission) {
        return equals(permission);
    }
}

