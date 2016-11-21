model {{ name }} {
{% for prop in properties %}
    {{prop.name}} {% if prop.type == Enum %}{{prop.enumModel.name}} {% else %}{{prop.type}} {% endif %}{% for const in prop.constrains %}{{const}} {% endfor %};
{% endfor %}
}