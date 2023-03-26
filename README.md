# Stock-trading-system
## Project Description: Securities Trading System based on Spring Cloud
Introduction
This project aims to build a 24/7 securities trading system based on Spring Cloud, which includes various components such as a database, messaging system, and cache. The chosen components should have high universality and wide usage. Therefore, the MySQL 8.x database, Kafka 3.x messaging system, and Redis 6.x cache system are selected.

The securities trading system's trades are based on trading pairs, such as BTC/USD, where USD is the quote asset, and BTC is the base asset. The system matches buy and sell orders based on price and time priority, achieving high liquidity and micro-based price discovery.

To simplify the design, this project is limited to supporting only one trading pair (BTC/USD) and does not charge any fees, simplifying the charging logic. It does not consider interfacing with banks and blockchain systems, simplifying asset access. It does not consider risk management requirements to focus on developing the core business system. It provides only a web interface and not a mobile app, and it does not have any backend management functionality.

## System Modules
For a system, creating a simple and reliable model can significantly simplify system design and implement a stable running system with fewer codes, thereby minimizing various unpredictable errors. Let's look at the securities trading system's business model.

For the securities trading system, the input is all buy and sell orders sent by traders. After receiving the order, the system undergoes sequencing, and then the matching engine performs buy and sell matching, and finally, the settled orders exchange base and quote assets, completing the transaction.

During the matching process, the system also needs to aggregate the transaction data based on the transaction price, transaction quantity, and transaction time, so that traders can intuitively see the historical transaction data in the form of a candlestick chart. Therefore, the quotation system is also part of the securities trading system. Additionally, the push system is responsible for pushing events such as market trends, order executions, and asset changes to clients.

Finally, the securities trading system needs to provide a UI interface for traders, typically a web or mobile app. The UI system will call the API internally, so the API is the only entry point for placing and canceling orders in the entire system.

The entire system can be logically divided into the following modules:

Trading API module (Trading API), an API entry point for traders to place and cancel orders.
Sequencer module (Sequencer), used to sequence all received orders.
Trading Engine module (Trading Engine), matching and settling orders after sequencing.
Quotation module (Quotation), aggregates matching output data to form a candlestick chart.
Push module (Push), pushes market trends, transaction results, and asset changes to users through WebSocket, etc.
UI module (UI), provides a web-based interface for traders and forwards trader operations to the backend API.
The trading engine is the most critical module and needs careful consideration to design a simple, reliable, and highly modular subsystem. For the securities trading system, the trading engine can be divided into the following modules:

Asset module: manages user assets.
Order module: manages active user orders (i.e., orders that have not been fully executed or canceled).
Matching engine: processes buy and sell orders and generates transaction information.
Settlement module: settles transaction information output by the matching engine, causing asset exchange between buyers and sellers.
The trading engine is an event-driven system, where the input is sequencing events, and the output is matching results and market trends data.
