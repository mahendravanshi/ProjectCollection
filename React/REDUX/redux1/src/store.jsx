import { createStore, applyMiddleware, combineReducers, legacy_createStore } from "redux";
import {reducer as countReducer } from "./CounterRedux/reducer";
import {reducer as dataReducer } from "./ProductRedux/reducer";
import { thunk } from "redux-thunk";




const rootReducer = combineReducers({
    countReducer,
    dataReducer
})


export  const store = legacy_createStore(rootReducer,applyMiddleware(thunk))


