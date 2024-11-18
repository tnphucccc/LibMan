import CounterReducer from "./reducers/CounterReducers";
import { thunk } from "redux-thunk";
import { configureStore, combineReducers } from "@reduxjs/toolkit";


const rootReducer = combineReducers({
  CounterStore: CounterReducer,
});



export const store = configureStore({
  reducer: rootReducer,
  middleware: (getDefaultMiddleware) => getDefaultMiddleware().concat(thunk),
});

export type RootState = ReturnType<typeof store.getState>;
export type AppDispatch = typeof store.dispatch;

