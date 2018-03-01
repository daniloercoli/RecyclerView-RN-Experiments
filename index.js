import React from 'react';
import {AppRegistry, StyleSheet, Text, TextInput, View} from 'react-native';
import RCTAztecView from './AztecView';

class SimpleTextInput extends React.Component {
  constructor(props) {
    super(props);
    this.state = {isShowingText: true};
  }


  render() {
let display = this.state.isShowingText ? this.props.my_text : ' ';
return (
      <View style={styles.container}>
        <RCTAztecView
         style={styles.hello}
         text = {display}
         editable = {true}
         autoGrow = {true}
         multiline = {true} />
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
    minHeight: 400,
   // color: 'red',
  },
});

AppRegistry.registerComponent('SimpleTextInput', () => SimpleTextInput);

        /*<TextInput style={styles.hello}
         editable = {true}
         autoGrow = {true}
         multiline = {true}>
         {display}
        </TextInput>*/