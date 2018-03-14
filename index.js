import React, { Component } from 'react';
import {AppRegistry, FlatList, StyleSheet, Text, TextInput, View} from 'react-native';
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
            <FlatList
              data={[
                {key: 'Stefanos'},
                {key: 'Mario'},
                {key: 'Danilo'},
                {key: 'Maxime'},
                {key: 'Koke'},
                {key: 'Ondrej'},
                {key: 'Cate'},
              ]}
              renderItem={({item}) =>
              <RCTAztecView
                       style={styles.hello}
                       text = {this.props.text}
                       color = {'black'}
                       maxImagesWidth = {300}
                       editable = {true}
                       autoGrow = {true}
                       multiline = {true} />
              }
            />
          </View>
        );
  }
}
var styles = StyleSheet.create({
    container: {
     flex: 1,
     paddingTop: 22
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