/**
 * osi model (7 layers model)
 *
 * 1: application layer: user interface
 * 2: presentation layer: data translation, data encryption and decryption, and compression..
 * 3: session layer: (node) this layer will manage and control the connections between nodes
 *                      establish, maintenance, termiantes
 *
 *
 *  4: transport layer:      this layer will tell you: data transmission is successfully send or not
 *
 * 5: network layer: this layer will transfer different lenght of data sequence from one node to another node
 *  between different network
 *          addressing, routing, congestion control
 * 6: data link layer: all data should be encoded and decoded into bits (10110101010)
 *              MAC address
 *  7: physical layer:   it converts data bits into electrical impulses or radio signal
 *
 *  TCP/IP model (4 layers)
 *  application layer: you will see a lot of different protocols: http, ftp, snmp, smtp
 *
 *  transport layer: responsible for end to end communication, data transfer
 *
 *  network layer:  this layer will send the data across the network, you will see source/ destination ip address
 *
 *  network access layer: it transfers the packets between different host. you will see encapsulation of ip into frames
 *  mapping ip address to physical hardware devices.
 *
 *
 *
 *  terms in tcp protocol
 *  syn: will tell another node/device, I want to establish connection  with you.
 *  ack: let us know the other side that it has received syn number
 *  ackNUM: next sequence number that receiver would like to receive: x + 1
 *  seq: keep track how many data it has sent and make sure data is delivered in the correct order
 *  FIN: I want to terminate the connection with you
 *
 *  establish connection in tcp:
 *  step1: the client sends a syn number which informs the server side that the client want to start connection
 *          (state for client: CLOSE TO SYN_SENT, client send syn to server)
 *  step2: server will respond to the client with ack, seq, syn numbers
 *          (state for server side: LISTEN to SYN_RCVD)
 *  step3: client will tell the server side, like : I received all things I need. here is ACK and seq
 *          (state for client: SYN_SENT to ESTABLISHED) -> once the server receive ACK and seq(state will change from SYN_RCVD to ESTABLISHED)
 *
 *
 *  connection terminate
 *  step 1: the client side send FIN, and change state from ESTABLISHED to FIN_WAIT_1
 *  step2: the server side send ACK, and change state from ESTABLISHED to CLOSE WAIT
 *  step3: the client receive ACK number and change state from FIN_WAIT_1 to FIN_WAIT_2
 *  step4: server side send FIN, and change state from CLOSE WAIT to LAST_ACK
 *  step5: client side receive FIN and change state from FIN_WAIT_2 to TIME WAIT
 *  step6: wait for some time and close connection.
 *
 *  UDP: time sensitive
 *  it is for transferring data between two nodes in a network with out establishing connection.
 *  you data can be lost in transit. you may get DDOS attack
 *  step1: data is prepared
 *  step2: data is sending
 *  step3: data is received
 *  step4: data is extracted.
 *
 *  DNS:
 *      naming system: www.google.com -> it is used to translate human readable domain name to ip address 123.123.123.123
 *
 *  HTTP
 *  HTTP request message:
 *      Method: GET
 *      path: /getStudentInfo
 *      version of the http protocol: HTTP/1.1
 *      Headers: host name, accept language...
 *
 * HTTP response message:
 *      version of protocol :HTTP/1.1
 *      status code: 200
 *      status message: OK
 *      Headers:
 *          date: Tue, Feb 25 2025, 2:23 pM CDT
 *          content length
 *          content type: HTML, text,..
 *          server
 *          ....
 *
 *      HTTP is stateless: each request will be treated independently
 *
 *
 *
 *      HTTP methods:
 *          get: retrieves data from database
 *          head: similar to get, but we only retrieve the info of headers
 *          post: sends data the server to create or update a resource
 *          put: replaces all current data, also can create a new resources it the resources does exist
 *          patch: partially update data
 *          delete: delete data
 *          ...
 *          options
 *          trace
 *          connect..
 *
 *          http status code:
 *          1XX: information: your request is well received and you can con continue process
 *          2XX: success: your requst is well received and understood and accepted.
 *                  200: 0k
 *                  201: created:
 *           3XX: redirection: your request will be redirected to somewhere else
 *           4XX:client error. you may have band syntax, your request cannot be fulfilled
 *           400 bad reqeust, 401: unauthorized. 404 not found
 *              5XX: server error: 500 internal server error
 *                                  503 service unavailable
 *                504 gateway timeout
 *
 *
 *
 *          HTTPS
 *              symmetric algorithm
 *                  we will use the same key for encryption and decryption
 *
 *              Asymmetric algorithm
 *                  we will use different key. public key and private key
 *
 *           HTTPS is using asymmetric algorithm
 *           HTTPS = http + ssl/tls whereas ssl/tls is encryption algorithm
 *
 *           step1: client wants to connect with the server
 *                  https://www.google.com
 *           step2: the server side receive your request and server side will send ssl/tls
 *                  and public key and certificate authority (CA)
 *
 *          step3: verification certificate
 *                  the client verifies the CA.
 *
 *          step4
 *              the client will generate pre-master secret for the session
 *                  this secret will be used to generate the session keys used for data encryption
 *           step5: the client side will encrypts pre-master secret with pulblic key
 *              and send it to the server side
 *
 *              step6: server and client sides will use pre-master secret to generate session key independently
 *
 *
 *
 *              step7: client and server ready
 *
 *
 *       http session vs cookie
 *       they are both used for maintain state and store information related to user.
 *
 *       session: session data will stored on the server and can be accessed and modified by the server -side code
 *              we use session to store user - specific information, authentication, user infor: id, age...
 *
 *
 *        cookie: it is very small piece of data stored on the user's browser
 *         we used cookie to store some infos(login credentials, user infos, .....) on the client side and send it back to the server side with according request
 *         cookie is generated by the server side and send it to client with http header
 *
 *
 *
 *
 *           kotlin :
 *
 *
 *
 *
 */
public class JavaDay6 {
    public static void main(String[] args) {

    }
}
