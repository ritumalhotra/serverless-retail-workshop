# Generated by Django 2.0.8 on 2018-10-10 09:20

from django.db import migrations


class Migration(migrations.Migration):

    dependencies = [
        ('fishing_equipment', '0005_auto_20181009_0554'),
    ]

    operations = [
        migrations.AlterModelOptions(
            name='category',
            options={'ordering': ['title'], 'verbose_name_plural': 'Categories'},
        ),
    ]
