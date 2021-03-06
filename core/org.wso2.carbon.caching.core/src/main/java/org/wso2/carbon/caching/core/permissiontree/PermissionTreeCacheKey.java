package org.wso2.carbon.caching.core.permissiontree;

import org.wso2.carbon.caching.core.CacheKey;

import java.io.Serializable;
/*
 * Copyright 2004,2005 The Apache Software Foundation.
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

public class PermissionTreeCacheKey extends CacheKey implements Serializable {

    private int cacheKeyId;

    private String serverId;

    private static final long serialVersionUID = 1281400603190208429L;

    public PermissionTreeCacheKey(String serverId, int cacheKeyId) {
        this.cacheKeyId = cacheKeyId;
        this.serverId = serverId;
    }
    public int getCacheKeyId() {
        return cacheKeyId;
    }

    public String getServerId() {
        return serverId;
    }

    @Override
    public boolean equals(Object otherObject) {
        
        if (!(otherObject instanceof PermissionTreeCacheKey)) {
            return false;
        }
        PermissionTreeCacheKey secondKey = (PermissionTreeCacheKey)otherObject;
        if(this.serverId != null){
            return  this.cacheKeyId == secondKey.getCacheKeyId() &&
                    this.serverId.equals(secondKey.getServerId());             
        } else {
            return this.getCacheKeyId() == secondKey.getCacheKeyId();
        }
    }

    @Override
    public int hashCode() {

        if(serverId != null){
            return this.cacheKeyId + this.serverId.hashCode() * 7 ;            
        } else {
            return this.cacheKeyId;
        }
    }
}
