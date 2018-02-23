import React from 'react';
import {AppRegistry, StyleSheet, Text, TextInput, View} from 'react-native';

class SimpleTextInput extends React.Component {
  constructor(props) {
    super(props);
    this.state = {isShowingText: true};
  }


  render() {
let display = this.state.isShowingText ? this.props.text : ' ';
return (
      <View style={styles.container}>
        <TextInput style={styles.hello}
         editable = {true}
         autoGrow = {true}
         multiline = {true}>
         {display}
        </TextInput>
      </View>
    );
  }
}
var styles = StyleSheet.create({
  container: {
    flex: 1,
  },
  hello: {
    fontSize: 20,
    margin: 10,
  },
});

AppRegistry.registerComponent('SimpleTextInput', () => SimpleTextInput);