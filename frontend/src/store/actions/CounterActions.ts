import { Dispatch } from "redux";
import { CounterActions } from "../../Constant";

export const increaseCount = () => {
    return (dispatch : Dispatch) => {
        dispatch({
            type: CounterActions.INCREMENT,
        });
    }
};

export const decreaseCount = () => {
    return (dispatch : Dispatch) => {
        dispatch({
            type: CounterActions.DECREMENT,
        });
    }
};

export const resetCount = () => {
    return (dispatch : Dispatch) => {
        dispatch({
            type: CounterActions.RESET,
        });
    }
};