/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package List;
import java.lang.reflect.Array;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Atahan Ekici
 */
public class MArrayList <T>
{
    private Object[] arr;
    
    public MArrayList(Class<T> c)
    {
        arr = (T[]) Array.newInstance(c, 0);
    }
    public MArrayList()
    {
        arr = new Object[0];
    }
    
    public int getSize()
    {
        return this.arr.length;
    }
    
    public T get(int index)
    {
        if(index < 0)
        {
            System.out.println("Index is too low");
            return null;
        } 
        else if(index > this.arr.length)
        {
            System.out.println("Index is too far");
            return null;
        }
        else
        {
            return (T)this.arr[index];
        }
    }
    
    private static void CopyArray(Object[] a1, Object[] a2) // First is the old one -smaller one- //
    {
        for(int i = 0;i<a1.length;i++)
        {
            a2[i] = a1[i];
        }
    }
    
    public void add(T data)
    {
        int len1 = (arr.length + 1);
        Object[] arr2 = new Object[len1];
        CopyArray(arr,arr2);
        
        int len2 = (arr2.length - 1);
        arr2[len2] = data;
        
        this.arr = arr2;
    }
    
    public void printAll()
    {
        if(this.arr.length <= 0)
        {
            System.out.println("No items inside this list");
            return;
        }
        
        for(int i=0;i<this.arr.length;i++)
        {
            System.out.println(""+(i+1)+") "+this.arr[i]+"");
        }
    }
    
    @Override
    public String toString()
    {
        String total = "List size: " +arr.length+  "\n";
        this.printAll();
        return total;
    }
    
    @Override
    protected void finalize()
    {
        try 
        { 
            super.finalize();
        } 
        catch (Throwable ex)
        {
            Logger.getLogger(MArrayList.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
