import React, { PureComponent } from "react";
import { ViewPropTypes, NativeModules, Platform } from "react-native";
import PropTypes from "prop-types";

const { RNPhotoEditor } = NativeModules;

class PhotoEditor extends PureComponent {
  static propTypes = {
    ...ViewPropTypes,
    path: PropTypes.string,
    stickers: PropTypes.array,
    controls: PropTypes.array,
    colors: PropTypes.array,
    onDone: PropTypes.func,
    onCancel: PropTypes.func
  };

  static defaultProps = {
    stickers: [],
    hiddenControls: [],
    colors: [
      "#1D2326",
      "#53565A",
      "#596B75",
      "#A0AFB7",
      "#FFFFFF",
      "#341948",
      "#3C3549",
      "#7D7098",
      "#603F8B",
      "#380515",
      "#750000",
      "#980147",
      "#B8390E",
      "#D37506",
      "#E88D72",
      "#FBCAA7",
      "#FFC0CB",
      "#9E6F6D",
      "#CBA124",
      "#FFD700",
      "#274472",
      "#145DA0",
      "#5885AF",
      "#6DB5D8",
      "#B5E5CF",
      "#21B6A8",
      "#007575",
      "#18A558",
      "#267055",
      "#024B29"
    ]
  };

  static Edit(props) {
    if (props.stickers === undefined)
      props.stickers = PhotoEditor.defaultProps.stickers;
    if (props.hiddenControls === undefined) props.hiddenControls = PhotoEditor.defaultProps.hiddenControls;
    if (props.colors === undefined) props.colors = PhotoEditor.defaultProps.colors

    RNPhotoEditor.Edit(
      props,
      (...args) => {
        props.onDone && props.onDone(...args);
      },
      (...args) => {
        props.onCancel && props.onCancel(...args);
      }
    );
  }
}

export { PhotoEditor as RNPhotoEditor }
