`timescale 1ns / 1ps 
//////////////////////////////////////////////////////////////////////////////////
// Company: 
// Engineer: 
// 
// Create Date: 01/15/2021 06:40:11 PM
// Design Name: 
// Module Name: top_demo
// Project Name: 
// Target Devices: 
// Tool Versions: 
// Description: 
// 
// Dependencies: 
// 
// Revision:
// Revision 0.01 - File Created
// Additional Comments:
// 
//////////////////////////////////////////////////////////////////////////////////

module top_demo
(
  // input
  input  logic [7:0] sw,
  input  logic [3:0] btn,
  input  logic       sysclk_125mhz,
  input  logic       rst,
  // output  
  output logic [7:0] led,
  output logic sseg_ca,
  output logic sseg_cb,
  output logic sseg_cc,
  output logic sseg_cd,
  output logic sseg_ce,
  output logic sseg_cf,
  output logic sseg_cg,
  output logic sseg_dp,
  output logic [3:0] sseg_an
);

  logic [16:0] CURRENT_COUNT;
  logic [16:0] NEXT_COUNT;
  logic        smol_clk;
  logic [3:0] Sum;
  logic Cout;
  
  
  // Place TicTacToe instantiation here
  rippleadder one (sw[3:0],sw[7:4],1'b0,Sum,Cout);
  
  // 7-segment display
  segment_driver driver(
  .clk(smol_clk),
  .rst(btn[3]),
  .digit0(sw[3:0]),
  .digit1(sw[7:4]),
  .digit2(Sum),
  .digit3(Cout),
  .decimals({1'b0, btn[2:0]}),
  .segment_cathodes({sseg_dp, sseg_cg, sseg_cf, sseg_ce, sseg_cd, sseg_cc, sseg_cb, sseg_ca}),
  .digit_anodes(sseg_an)
  );

// Register logic storing clock counts
  always@(posedge sysclk_125mhz)
  begin
    if(btn[3])
      CURRENT_COUNT = 17'h00000;
    else
      CURRENT_COUNT = NEXT_COUNT;
  end
  
  // Increment logic
  assign NEXT_COUNT = CURRENT_COUNT == 17'd100000 ? 17'h00000 : CURRENT_COUNT + 1;

  // Creation of smaller clock signal from counters
  assign smol_clk = CURRENT_COUNT == 17'd100000 ? 1'b1 : 1'b0;
  

endmodule

module fulladder(input logic a, b, cin,
                    output logic sum, cout);

        logic g1,g2;

        assign g1 = a ^ b;
        assign g2 = a & b;

        assign sum = g1 ^ cin;
        assign cout = g2 | (g1 & cin);
endmodule

module rippleadder(input logic [3:0] A,
                    input logic [3:0] B, 
                    input logic CarryIn, 
                    output logic [3:0] Sum, 
                    output logic CarryOutTotal);

        logic CarryOut1, CarryOut2, CarryOut3;   
        
            fulladder one(A[0], B[0], CarryIn, Sum[0], CarryOut1);
            fulladder two(A[1], B[1], CarryOut1, Sum[1], CarryOut2);
            fulladder three(A[2], B[2], CarryOut2, Sum[2], CarryOut3);
            fulladder four(A[3], B[3], CarryOut3, Sum[3], CarryOutTotal);

endmodule