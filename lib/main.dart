import 'package:flutter/material.dart';

void main() => runApp(MyApp());

class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Flutter Fragment Demo',
      theme: ThemeData(
        primarySwatch: Colors.blue,
      ),
      home: Scaffold(
        appBar: AppBar(
          title: Text('Flutter Fragment Demo'),
        ),
        body: ListView(
          children: List.generate(20, (i) => i)
              .map((element) => TextField(
            decoration: InputDecoration(hintText: '$element'),
          ))
              .toList(),
        ),
      ),
    );
  }
}
