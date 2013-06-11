package org.rackspace.gdeproxy

/**
 *  An object containing the initial request sent via the make_request method,
 *  and all request/response pairs (Handling objects) processed by
 *  DeproxyEndpoint objects.
 */


//class MessageChain:
class MessageChain {

  def sentRequest
  def receivedResponse
  def defaultHandler
  def handlers = [:]
  def handlings = []
  def orphanedHandlings = []
  def _lock = new Object()

  //    def __init__(self, default_handler, handlers):
  //        """
  //Params:
  //default_handler - An optional handler function to use for requests
  //related to this MessageChain, if not specified elsewhere
  //handlers - A mapping object that maps endpoint references or names of
  //endpoints to handlers
  //"""
  public MessageChain(defaultHandler=null, handlers=null) {
    //        self.sent_request = None
    //        self.received_response = None
    //        self.default_handler = default_handler
    //        self.handlers = handlers
    //        self.handlings = []
    //        self.orphaned_handlings = []
    //        self.lock = threading.Lock()
      
  }

  def addHandling(handling) {
    synchronized (_lock) {
      this.handlings.add(handling)
    }
  }

  def addOrphanedHandling(handling) {
    synchronized (_lock) {
      this.orphanedHandlings.add(handling)
    }
  }

  String toString() {
    sprintf('MessageChain(handler_function=%r, sent_request=%r, handlings=%r, received_response=%r, orphaned_handlings=%r)',
      handlerFunction, sentRequest, handlings, receivedResponse, orphanedHandlings)
  }
}

//    """
//An object containing the initial request sent via the make_request method,
//and all request/response pairs (Handling objects) processed by
//DeproxyEndpoint objects.
//"""
//
//    def add_handling(self, handling):
//        with self.lock:
//            self.handlings.append(handling)
//
//    def add_orphaned_handling(self, handling):
//        with self.lock:
//            self.orphaned_handlings.append(handling)
//
//    def __repr__(self):
//        return ('MessageChain(default_handler=%r, handlers=%r, '
//                'sent_request=%r, handlings=%r, received_response=%r, '
//                'orphaned_handlings=%r)' %
//                (self.default_handler, self.handlers, self.sent_request,
//                 self.handlings, self.received_response,
//                 self.orphaned_handlings))