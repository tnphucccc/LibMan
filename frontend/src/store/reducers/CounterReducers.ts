import { CounterActions } from "../../Constant";

export interface CounterState {
    count: number;
}
  
  
  
const initState: CounterState = {
    count: 0,
};
  
  
  
const counterReducer = (state = initState, action: any): CounterState => {
    switch (action.type) {
        case CounterActions.INCREMENT:
            return {
                ...state,
                count: state.count + 1,
            };
        case CounterActions.DECREMENT:
            return {
                ...state,
                count: state.count - 1,
            };
        case CounterActions.RESET:
            return {
                ...state,
                count: 0,
            };
        default:
        return state;
    }
};

export default counterReducer;
  