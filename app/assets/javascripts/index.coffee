$ ->
  $.get "/board", (boards) ->
    $.each boards, (index, board) ->
      $("#boards").append $("<li>").text board.name + ": " + board.description