import PropTypes from 'prop-types';
import {requireNativeComponent, ViewPropTypes} from 'react-native';

var aztex = {
  name: 'AztecView',
  propTypes: {
    text: PropTypes.string,
    color: PropTypes.string,
    ...ViewPropTypes, // include the default view properties
  },
};

module.exports = requireNativeComponent('RCTAztecView', aztex);