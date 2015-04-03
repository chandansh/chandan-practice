

/**
 * HelloWorldService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */

    package com.service;

    /*
     *  HelloWorldService java interface
     */

    public interface HelloWorldService {
          

        /**
          * Auto generated method signature
          * 
                    * @param sayHello0
                
         */

         
                     public com.service.SayHelloResponse sayHello(

                        com.service.SayHello sayHello0)
                        throws java.rmi.RemoteException
             ;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param sayHello0
            
          */
        public void startsayHello(

            com.service.SayHello sayHello0,

            final com.service.HelloWorldServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param sayBye2
                
         */

         
                     public com.service.SayByeResponse sayBye(

                        com.service.SayBye sayBye2)
                        throws java.rmi.RemoteException
             ;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param sayBye2
            
          */
        public void startsayBye(

            com.service.SayBye sayBye2,

            final com.service.HelloWorldServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        
       //
       }
    