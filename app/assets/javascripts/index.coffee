$ ->
  $.get "/lists", (lists) ->
    $.each lists, (index, list) ->
      $("#lists").append $("<li>").text list.name + ": " + list.description