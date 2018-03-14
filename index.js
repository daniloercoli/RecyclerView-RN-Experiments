import React from 'react';
import {AppRegistry, StyleSheet, Text, TextInput, View} from 'react-native';
import RCTAztecView from './AztecView';

class SimpleTextInput extends React.Component {
  constructor(props) {
    super(props);
    this.state = {isShowingText: true};
  }


  render() {
//let display = this.state.isShowingText ? this.props.my_text : ' ';
return (
      <View style={styles.container}>
        <RCTAztecView
         style={styles.hello}
         text = {this.props.text}
         color = {'black'}
         maxImagesWidth = {300}
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
    margin: 10,
    minHeight: 200,
  },
});

AppRegistry.registerComponent('SimpleTextInput', () => SimpleTextInput);

        /*<TextInput style={styles.hello}
         editable = {true}
         autoGrow = {true}
         multiline = {true}>
         {display}
        </TextInput>*/