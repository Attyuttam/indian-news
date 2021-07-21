import React from "react";
import { Client } from "@stomp/stompjs";

const SOCKET_URL = "ws://localhost:8094/ws-message";

class App extends React.Component {
  constructor() {
    super();
    this.state = {
      messages: [],
    };
  }

  componentDidMount() {
    let currentComponent = this;
    let onConnected = () => {
      console.log("Connected!!");
      client.subscribe("/topic/message", function (msg) {
        if (msg.body) {
          var jsonBody = JSON.parse(msg.body);

          if (jsonBody.status === "ok") {
            currentComponent.setState((prevState) => ({
              messages: jsonBody.articles,
            }));
          }
        }
      });
    };

    let onDisconnected = () => {
      console.log("Disconnected!!");
    };

    const client = new Client({
      brokerURL: SOCKET_URL,
      reconnectDelay: 5000,
      heartbeatIncoming: 4000,
      heartbeatOutgoing: 4000,
      onConnect: onConnected,
      onDisconnect: onDisconnected,
    });
    client.activate();
  }

  render() {
    return (
      <div style={{padding:"1.125rem"}}>
        <h1>THE INDIAN NEWS</h1>
        <table  style={{border:"1px solid black",width:"100%", tableLayout:"fixed",borderCollapse:"collapse"}}>
          <tbody>
            
              {this.state.messages.map((message) => (
                <tr style={{overflow:"hidden"}}>
                  <td style={{border:"1px solid black",padding:"25px"}} ><img src={message.urlToImage} height="250px" width="200px"/></td>
                  <td style={{border:"1px solid black",padding:"25px",width:"80%"}}>
                    <div style={{width:"100%"}}>
                    <b>Title:</b> {message.title}<br/>
                    <b>Author:</b> {message.author}<br/>
                    <b>Content:</b> {message.content}<br/>
                    <b>Description:</b> {message.description}<br/>
                    <b>PublishedAt:</b> {message.publishedAt}<br/>
                    <b>Link:</b> <a href={message.url} target="_blank">{message.url}</a><br/>
                    </div>
                  </td>
                </tr>
              ))}
            
          </tbody>
        </table>
      </div>
    );
  }
}

export default App;
