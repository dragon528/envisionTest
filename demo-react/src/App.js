import React, { Component } from 'react';
import 'bootstrap/dist/css/bootstrap.min.css';

class App extends Component {

  constructor(props) {
    super(props);
    this.handleSubmit = this.handleSubmit.bind(this);
    this.state = {
      result: []
    };
  };

  handleSubmit(event) {
    event.preventDefault();
    const data = new FormData(event.target);

    fetch('http://localhost:8080/', {
      method: 'POST',
      body: data,
    })
    .then((response) => {
      response.text()
      .then((responseData) => {
        this.setState({
          result: JSON.parse(responseData)
        });
      })
    })
    .catch(error => console.warn(error));
  };

  render() {
      return (
        <div className="container">
            <div className="row">
              <form onSubmit={this.handleSubmit}>
                <input type="text" name="name"></input>
                <button>Submit</button>
              </form>
            </div>
            <ul>
              {this.state.result.map((value) => {
                return (
                  <div key={value.id}>
                  <li>Titles:<p>{value.title}</p>Name:<p>{value.name}</p></li>
                  </div>
                )
              })}
            </ul>
        </div>
      );
    }
  }

export default App;
