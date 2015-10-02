# Pusher ReactNative Android

```js
var pusher = require('pusher-react-native-android');

var MyComponent = React.createClass({


  componentWillMount: function() {

    pusher.connect('YOUR_APP_KEY');

    pusher.subscribe('test_channel');

    pusher.listen("test_channel", "my_event", (({message}) => {
      this.setState({message: message});
    }));

  }

});

```

## To-Do

* Error handling
* Logging
* Disconnecting
* Listen to connection events
* Client events
* Unbinding to events
* Unsubscribing to channels
* Expose connection state
* Auth options